let i18n;
let i18nPromise = new Promise((resolve, reject) => {
    $.ajax({
        url: "/i18n",
        dataType: 'json',
        type: "GET",
        success(data){
            i18n = data;
            console.log(i18n);
            resolve(data);
        },
        error(jqXHR, textStatus, errorThrown) {
            reject(new Error(errorThrown));
        }
    });
});

function TablaRevenue() {
    let table;
    $.ajax({
        url: "/userAPI/recentRevenue",
        dataType: 'json',
        type: "GET",
        success: function (data) {
            // Inicializa DataTables y guarda la referencia en la variable table
            table = $('.tableSection #revenue').DataTable({
                responsive: {
                    details: {
                        display: $.fn.dataTable.Responsive.display.modal({
                            header: function (row) {
                                var data = row.data();
                                return `${i18n['admin.detalles']}`
                            }
                        }),
                        renderer: $.fn.dataTable.Responsive.renderer.tableAll({
                            tableClass: 'dtr-modal-content'
                        })
                    }
                },
                data: data,
                columns: [
                    { data: 'idRevenue', title: 'ID Revenue' },
                    { data: 'revenueHeader', title: 'Revenue Header' },
                    { data: 'revenueDescription', title: 'Revenue Description' },
                    { data: 'revenueDate', title: 'Date' },
                    { data: 'revenueAmount', title: 'Amount' },
                    {
                        data: null,
                        title: `${i18n['user.editar']}`,
                        className: 'text-center border-right',
                        render: function (data, type, row) {
                            return `<button class="btn btn-primary edit-button" data-idExpenses="${data.idRevenue}">${i18n['user.editar']}</button>`;
                        }
                    },
                    {
                        data: null,
                        title: `${i18n['user.eliminar']}`,
                        className: 'text-center border-right',
                        render: function (data, type, row) {
                            return `<button class="btn btn-danger delete-button" data-idExpenses="${data.idRevenue}">${i18n['user.eliminar']}</button>`;
                        }
                    }
                ],
                columnDefs: [
                    { className: 'border-right border-bottom', targets: '_all' } // Agrega las clases 'border-right' y 'border-bottom' a todas las columnas
                ]
            });
        },
        error: function (error) {
            console.log(error);
        }
    });

    $(document).on('click', '.edit-button', function () {
        var idexpenses = $(this).data('idexpenses');
        window.location.href += `/edit/${idexpenses}`
    });

    $(document).on('click', '.delete-button', function () {

        let idexpenses = $(this).data('idexpenses');
        console.log(idexpenses)

        let confirmacion = confirm(i18n['user.delete.confirm'])

        if (confirmacion) {

            $.ajax({
                url: `/adminAPI/deleteExpense/${idexpenses}`,
                type: "DELETE",
                success: function (data) {
                    table.destroy();
                    TablaExpenses();
                },
                error: function (error) {
                    alert("ERROR");
                }
            });

        }

    });

}

i18nPromise.then(function() {
    TablaRevenue();
}).catch(function(error) {
    console.error("Error occurred:", error);
});

let today = new Date();
let dd = String(today.getDate()).padStart(2, '0');
let mm = String(today.getMonth() + 1).padStart(2, '0'); //Enero es 0!
let yyyy = today.getFullYear();

today = yyyy + '-' + mm + '-' + dd;
document.getElementById('date').max = today;
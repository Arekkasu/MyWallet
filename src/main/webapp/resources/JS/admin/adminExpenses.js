import {i18n, i18nPromise} from '../i18n.js';


function TablaRevenue() {
    let table;
    $.ajax({
        url: "/adminAPI/expensesList",
        dataType: 'json',
        type: "GET",

        success: function (data) {

            table =
                $('.tableSection #expenses').DataTable({
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
                        {data: 'idExpenses', className: 'text-center', title: 'ID'},
                        {data: 'expenseHeader', title: 'Expense Header'},
                        {data: 'expenseDescription', title: 'Expense Description'},
                        {data: 'expenseDate', title: 'Expense Date'},
                        {data: 'expenseAmount', title: 'Expense Amount'},
                        {data: 'users.username', title: 'Username'}, // Solo el nombre de usuario del usuario
                        {
                            data: null,
                            title: `${i18n['user.editar']}`,
                            className: 'text-center border-right',
                            render: function (data, type, row) {
                                return `<button class="btn btn-primary edit-button" data-idExpenses="${data.idExpenses}">${i18n['user.editar']}</button>`;
                            }
                        },
                        {
                            data: null,
                            title: `${i18n['user.eliminar']}`,
                            className: 'text-center border-right',
                            render: function (data, type, row) {
                                return `<button class="btn btn-danger delete-button" data-idExpenses="${data.idExpenses}">${i18n['user.eliminar']}</button>`;
                            }
                        }
                    ],
                    columnDefs: [
                        {className: 'border-right border-bottom', targets: '_all'}
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
                    TablaRevenue();
                },
                error: function (error) {
                    alert("ERROR");
                }
            });

        }

    });

}


i18nPromise.then(function () {
    TablaRevenue();
});


//ESTABLECIENDO LIMITE DEL FRONT
let today = new Date();
let dd = String(today.getDate()).padStart(2, '0');
let mm = String(today.getMonth() + 1).padStart(2, '0'); //Enero es 0!
let yyyy = today.getFullYear();

today = yyyy + '-' + mm + '-' + dd;
document.getElementById('date').max = today;


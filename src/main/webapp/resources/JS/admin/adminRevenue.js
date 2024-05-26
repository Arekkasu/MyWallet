import {i18n, i18nPromise} from '../i18n.js';


function TablaRevenue() {
    let table;
    $.ajax({
        url: "/adminAPI/revenuesList",
        dataType: 'json',
        type: "GET",
        success: function (data) {

            table =
                $('.tableSection #revenue').DataTable({
                    responsive: {
                        details: {
                            display: $.fn.dataTable.Responsive.display.modal({
                                header: function (row) {
                                    var data = row.data();
                                    return `${i18n['admin.detalles']}`
                                }
                            }),
                            renderer: $.fn.dataTable.Responsive.renderer.tableAll({
                                tableClass: 'table'
                            })
                        }
                    },
                    data: data,
                    columns: [
                        {data: 'idRevenue', className: 'text-center', title: 'ID'},
                        {data: 'revenueHeader', title: 'Revenue Header'},
                        {data: 'revenueDescription', title: 'Revenue Description'},
                        {data: 'revenueDate', title: 'Revenue Date'},
                        {data: 'revenueAmount', title: 'Revenue Amount'},
                        {data: 'users.username', title: 'Username'}, // Agregado
                        {
                            data: null,
                            title: `${i18n['user.editar']}`,
                            className: 'text-center border-right',
                            render: function (data, type, row) {
                                return `<button class="btn btn-primary edit-button" data-idRevenue="${data.idRevenue}">${i18n['user.editar']}</button>`;
                            }
                        },
                        {
                            data: null,
                            title: `${i18n['user.eliminar']}`,
                            className: 'text-center border-right',
                            render: function (data, type, row) {
                                return `<button class="btn btn-danger delete-button" data-idRevenue="${data.idRevenue}">${i18n['user.eliminar']}</button>`;
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
        var Idusername = $(this).data('idrevenue');
        window.location.href += `/edit/${Idusername}`
        // Aquí puedes agregar el código para editar el usuario con el nombre de usuario
    });

    $(document).on('click', '.delete-button', function () {

        let Idrevenue = $(this).data('idrevenue');
        console.log(Idrevenue)
        let confirmacion = confirm(i18n['user.delete.confirm'])

        if (confirmacion) {

            $.ajax({
                url: `/adminAPI/deleteRevenue/${Idrevenue}`,
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


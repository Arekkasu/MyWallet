import {i18n, i18nPromise} from '../i18n.js';


function TablaUsuario() {
    let table;
    $.ajax({
        url: "/adminAPI/usersList",
        dataType: 'json',
        type: "GET",
        success: function (data) {
            // Inicializa DataTables y guarda la referencia en la variable table
            table = $('#usersTable').DataTable({
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
                    { data: 'idUsers', className: 'text-center',title: 'ID' },
                    { data: 'email', title: 'Email' },
                    { data: 'username', title: 'Username' },
                    { data: 'totalAmount', title: 'Total Amount' },
                    {
                        data: null,
                        title: `${i18n['user.editar']}`,
                        className: 'text-center border-right',
                        render: function(data, type, row) {
                            return `<button class="btn btn-primary edit-button" data-idUsers="${data.idUsers}">${i18n['user.editar']}</button>`;
                        }
                    },
                    {
                        data: null,
                        title: `${i18n['user.eliminar']}`,
                        className: 'text-center border-right',
                        render: function(data, type, row) {
                            return `<button class="btn btn-danger delete-button" data-idUsers="${data.idUsers}">${i18n['user.eliminar']}</button>`;
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
    $(document).on('click', '.edit-button', function() {
        var Idusername = $(this).data('idusers');
        window.location.href+= `/edit/${Idusername}`
        // Aquí puedes agregar el código para editar el usuario con el nombre de usuario
    });

    $(document).on('click', '.delete-button', function() {
        let Idusername = $(this).data('idusers');
        let confirmacion = confirm(i18n['user.delete.confirm'])

        if(confirmacion){

            $.ajax({
                url: `/adminAPI/deleteUser/${Idusername}`,
                type: "DELETE",
                success: function (data) {
                    table.destroy();
                    TablaUsuario();
                },
                error: function (error) {
                    alert("ERROR");
                }
            });

        }

    });

}



i18nPromise.then(function() {
    TablaUsuario();
});




// CREACION DEL DATA TABLE







//ACTIVAR HOVER DE EDITAR O ELIMINAR


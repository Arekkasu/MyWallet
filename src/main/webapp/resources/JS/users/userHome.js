import {i18n, i18nPromise} from '../i18n.js';


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
                    { data: 'revenueHeader', title: 'Revenue Header' },
                    { data: 'revenueDescription', title: 'Revenue Description' },
                    { data: 'revenueDate', title: 'Date' },
                    { data: 'revenueAmount', title: 'Amount' },
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

}

function TablaExpenses() {
    let table;
    $.ajax({
        url: "/userAPI/recentExpenses",
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
                        {data: 'expenseHeader', title: 'Expense Header'},
                        {data: 'expenseDescription', title: 'Expense Description'},
                        {data: 'expenseDate', title: 'Expense Date'},
                        {data: 'expenseAmount', title: 'Expense Amount'}, // Solo el nombre de usuario del usuario
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


}




i18nPromise.then(function() {
    TablaRevenue();
    TablaExpenses();
});

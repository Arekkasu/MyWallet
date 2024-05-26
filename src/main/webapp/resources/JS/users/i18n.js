//quiero es exportar el i18n para poder usarlo en cualquier archivo js

export let i18n;
export let i18nPromise = $.ajax(
    {
        url: "/i18n",
        dataType: 'json',
        type: "GET",
        success(data){
            i18n = data;
            console.log(i18n);
        }
    }
);
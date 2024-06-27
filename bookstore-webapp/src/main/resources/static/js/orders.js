document.addEventListener('alpine:init', () => {
    Alpine.data('initData', () => ({
        orders: [],
        init() {
            this.loadOrders();
            updateCartItemCount();
        },
        loadOrders() {
            //$.getJSON("http://localhost:8989/orders/api/orders", (data) => {
            //$.getJSON(apiGatewayUrl+"/orders/api/orders", (data) => {
            $.getJSON("/api/orders", (data) => {
                //console.log("orders :", data)
                this.orders = data
            });
        },
    }))
});
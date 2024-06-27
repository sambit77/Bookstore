document.addEventListener('alpine:init', () => {
    Alpine.data('initData', (orderNumber) => ({
        orderNumber: orderNumber,
        orderDetails: {
            items: [],
            customer: {},
            deliveryAddress: {}
        },
        init() {
            updateCartItemCount();
            this.getOrderDetails(this.orderNumber)
        },
        getOrderDetails(orderNumber) {
            //$.getJSON("http://localhost:8989/orders/api/orders/"+ orderNumber, (data) => {
            //$.getJSON(apiGatewayUrl+"/orders/api/orders/"+ orderNumber, (data) => {
             $.getJSON("/api/orders/"+ orderNumber, (data) => {
                //console.log("Get Order Resp:", data)
                this.orderDetails = data
            });
        }
    }))
});
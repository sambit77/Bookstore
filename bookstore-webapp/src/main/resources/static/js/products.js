document.addEventListener('alpine:init', () => {
    Alpine.data('initData', (pageNo) => ({
        pageNo: pageNo,
        products: {
            data: []
        },
        init() {
            this.loadProducts(this.pageNo);
            //updateCartItemCount();
        },
        loadProducts(pageNo) {
            //$.getJSON("http://localhost:8989/catalog/api/products?page="+pageNo, (resp)=> {
            //$.getJSON(apiGatewayUrl+"/catalog/api/products?page="+pageNo, (resp)=> {
            $.getJSON("/api/products?page="+pageNo, (resp)=> {
                console.log("Products Resp:", resp)
                this.products = resp;
            });
        },
        addToCart(product) {
            addProductToCart(product)
        }
    }))
});
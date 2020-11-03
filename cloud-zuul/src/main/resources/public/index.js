/**
 * 判断登陆 否则进入登陆界面
 * 执行首页数据方法
 */
window.onload=function () {
    Vue.component('book-page', {
        props: {
            books: Array
        },
        template:
            `<div>
                <el-row>
                    <el-col :span="2">
                        <h1>书籍服务</h1>
                    </el-col>
                </el-row>
                <el-table :data="books"
                    height="350"
                    border
                    style="width: 100%">
                    <el-table-column
                            prop="id"
                            label="书籍ID">
                    </el-table-column>
                    <el-table-column
                            prop="name"
                            label="书籍名称">
                    </el-table-column>
                    <el-table-column
                            prop="category"
                            label="类别">
                    </el-table-column>
                    <el-table-column
                            prop="repertory"
                            label="库存">
                    </el-table-column>
                </el-table>
            </div>`
    })
    Vue.component('order-page', {
        props: {
            orders: Array
        },
        template:
            `<div>
                <el-row>
                    <el-col :span="2">
                        <h1>订单服务</h1>
                    </el-col>
                </el-row>
                <el-table :data="orders"
                    height="350"
                    border
                    style="width: 100%">
                    <el-table-column
                            prop="id"
                            label="订单ID">
                    </el-table-column>
                    <el-table-column
                            prop="goodsId"
                            label="书籍ID">
                    </el-table-column>
                    <el-table-column
                            prop="userId"
                            label="用户ID">
                    </el-table-column>
                    <el-table-column
                            prop="date"
                            label="订单时间">
                    </el-table-column>
                </el-table>
            </div>`
        ,
    })
    var app = new Vue({
        el: '#app',
        data: {
            token: "",
            view:'1',
            //书籍数据
            books:[],
            //订单数据
            orders:[],
            dialogFormVisible: false,
            form: {
                username: '',
                password:'',
            },
            formLabelWidth: '80px'
        },
        methods:{
            /**
             * 切换视图
             * @param index
             * @param indexPath
             */
            showPage(index, indexPath) {
                switch (index) {
                    case '1':
                        let that1 = this;
                        axios.get('/api/v1/book/book/',{
                            headers: {'Authorization': "Bearer "+app.token}
                        }).then(function (response) {
                            // handle success
                            that1.books=response.data.data
                            console.log("书籍页面数据刷新")
                            console.log(response.data.data);
                        })
                        .catch(function (error) {
                            // handle error
                            console.log("错误回调")
                            console.log(error);
                            app.dialogFormVisible=true;
                        })
                        .then(function () {
                            // always executed
                        });
                        break;
                    case '2':
                        let that2 = this;
                        // eslint-disable-next-line no-unused-vars,no-case-declarations
                        axios.get('/api/v1/order/order',{
                            headers: {'Authorization': "Bearer "+app.token}
                        })
                        .then(function (response) {
                            // handle success
                            that2.orders=response.data.data;
                            console.log("订单服务刷新")
                            console.log(response.data.data)
                        })
                        .catch(function (error) {
                            // handle error
                            console.log("错误回调")
                            console.log(error);
                            app.dialogFormVisible=true;
                        })
                        .then(function () {
                            // always executed
                        });
                        break;
                }
                this.view = index;
            },
            /**
             * 身份认证
             */
            submit(){
                console.log("认证服务器");
                console.log(this.form.username);
                /**
                 * 认证服务器
                 */
                var bodyFormData = new FormData();
                bodyFormData.append('grant_type', 'password');
                bodyFormData.append("scope","webclient");
                bodyFormData.append("username",this.form.username);
                bodyFormData.append("password",this.form.password);
                let that1 = this;
                axios({
                    method: 'post',
                    url: '/api/v1/authorization/oauth/token',
                    auth: {
                        username: 'cloud-security',
                        password: 'cloud-security-admin'
                    },
                    data: bodyFormData,
                    headers: {'Content-Type': 'application/x-www-form-urlencoded' }
                })
                    .then(function (response) {
                        //handle success
                        console.log(response);
                        that1.token=response.data.access_token;
                        that1.dialogFormVisible=false;
                        /**
                         * 认证成功 刷新
                         */
                        that1.showPage('1','');
                    })
                    .catch(function (response) {
                        //handle error
                        console.log(response);
                    });
            }
        },
    });
    /**
     * 抓取书籍页面数据
     */
    axios.get('/api/v1/book/book/',{
        headers: {'Authorization': "Bearer "+app.token}
    })
        .then(function (response) {
            // handle success
            console.log(response);
            app.books=response.data.data;
        })
        .catch(function (error) {
            // handle error
            console.log("错误回调")
            console.log(error);
            app.dialogFormVisible=true;
        })
        .then(function () {
            // always executed
        });
}
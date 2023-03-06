var mysql = require("mysql");

/* 함수만 반환할 떄 */
// exports.getList = function(){}; 

/* 객체를 반환할 떄 */
module.exports = class NoticeService {

    constructor() {
    }

    getList(page = 1) {

        return new Promise((resolve, reject) => {

            var con = mysql.createConnection({
                host: "dev.notepubs.com",
                port: 9898,
                database: "newlecture",
                user: "newlecture",
                password: "111",
                insecureAuth: true
            });
            
            con.connect(function (err) {
    
                if (err) throw err;
                console.log("connected");

                con.query("SELECT * FROM Notice", function (error, results, fields) {
                    if (error) throw error;
                    resolve(results);
                    con.end();
                });
    
            });

        });

    }

}
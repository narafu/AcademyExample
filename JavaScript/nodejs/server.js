
let http = require("http");
let express = require("express");
let path = require("path");

let indexController = require('./controller/indexController.js');

let app = express();
app.set("views", path.join(__dirname, "view")); /* 뷰 디렉토리 */
app.set("view engine", "ejs"); /* 뷰 엔진 */

let server = http.createServer(app);
server.listen(3000);

app.use("/", indexController);

// let http = require('http');
// let server = http.createServer();

// server.on("request", (req, res) => {
//     // console.log("요청이 왔습니다");
//     res.write("Hello NodeJS!");
//     res.end();
// });
// server.listen(3000); /* 포트번호 */
// // server.accept(); 
// console.log("accept");


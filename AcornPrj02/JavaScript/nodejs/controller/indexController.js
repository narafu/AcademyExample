
// exports. render = (req, res, next) => {
//     res.send("홈페이지");
//     res.end();
// }

let express = require("express");
let rounter = express.Router();

rounter.get('/index', (req, res, next) => {
    // res.send('Hello World'); /* 뷰가 없을 때 */
    // res.render("index.ejs", { test: "hello" }); /* 뷰(ejs)를 출력할 때 */
    res.json({ test: "hello" }) /* json 출력할 때 */
});

module.exports = rounter;
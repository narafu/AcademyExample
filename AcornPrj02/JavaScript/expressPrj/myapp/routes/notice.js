var express = require('express');
var router = express.Router();
var NoticeService = require('../service/noticeservice.js');

/* GET users listing. */
router.get('/list', function (req, res, next) {

  var noticeService = new NoticeService();

  /* 비동기 */
  // noticeService
  //   .getList()
  //   .then(function (list) {
  //     res.render("notice/list", { list });
  //   });

  /* 동기 - async는 자바의 thread와 비슷한 개념 */
  (async () => {
    var list = await noticeService.getList();
    // res.render("notice/list", { list });
    res.json({list}); /* json으로 보내기 */
  })();

});

module.exports = router;

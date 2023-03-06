
class SecurityContext {

    constructor() {
        this._userName = null;
        this._authorities = [];
        this._defaultRole = null;
    }
      
    // get, set 함수는 속성처럼 사용한다. ex) userName.~
    get userName() {
        return this._userName;
    }

    set userName(userName) {
        this._userName = userName;
    }

}

export default new SecurityContext();
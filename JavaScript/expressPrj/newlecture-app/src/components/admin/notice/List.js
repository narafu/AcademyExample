import React from 'react';
import { Link } from 'react-router-dom';
import Pager from '../../inc/Pager';

class List extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            notices: [{
                id: 1, title: 'hello'
            },
            {
                id: 2, title: 'good morning'
            }],
            count: 32,
            curPage: 1,
            lastPage: 0,
            query: "",
            fieldSelected: "title"
        };
    }
    componentDidMount() {
        console.log(this.props.location.search);
        fetch("http://localhost:8080/api/notice/list" + this.props.location.search)
            .then(response => {
                return response.json();
            })
            .then(json => {
                this.setState({
                    notices: json
                });
            });
        console.log("didMount");
    }
    componentDidUpdate() {
        console.log("didUpdate");
    }
    pagerClick({ num }) {
        let queryString = this.props.location.search;
        let field = "";
        let query = "";
        this.props.history.push(`/customer/notice/list?p=${num}&f=title&q=asdf`);
        //alert("클릭클릭!!");
    }
    searchButtonClick(e) {
        e.preventDefault();
        let field = this.state.fieldSelected;
        let query = this.state.query;
        this.props.history.push(`/customer/notice/list?p=${1}&f=${field}&q=${query}`);

    }
    render() {
        return (<main className="main">
            <h2 className="main title">공지사항</h2>

            <div className="breadcrumb">
                <h3 className="hidden">경로</h3>
                <ul>
                    <li>home</li>
                    <li>고객센터</li>
                    <li>공지사항</li>
                </ul>
            </div>

            <div className="search-form margin-top first align-right">
                <h3 className="hidden">공지사항 검색폼</h3>
                <form className="table-form">
                    <fieldset>
                        <legend className="hidden">공지사항 검색 필드</legend>
                        <label className="hidden">검색분류</label>
                        <select name="f" onChange={e => { this.setState({ fieldSelected: e.target.value }) }}>
                            <option value="title">제목</option>
                            <option value="writerId">작성자</option>
                        </select>
                        <label className="hidden">검색어</label>
                        <input type="text" name="q" ref="queryInput" value={this.state.query} onInput={e => { this.setState({ query: e.target.value }) }} />
                        <input className="btn btn-search" type="submit" value="검색" onClick={this.searchButtonClick.bind(this)} />
                        <input type="hidden" name="p" value="1"/>
                    </fieldset>
                </form>
            </div>

            <div className="notice margin-top">
                <h3 className="hidden">공지사항 목록</h3>
                <table className="table">
                    <thead>
                        <tr>
                            <th className="w60">번호</th>
                            <th className="expand">제목</th>
                            <th className="w100">작성자</th>
                            <th className="w100">작성일</th>
                            <th className="w60">조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.notices.map(n => {
                            return <tr>
                                <td>{n.id}</td>
                                <td className="title indent text-align-left"><Link to={"/customer/notice/detail"}>{n.title}</Link></td>
                                <td>newlec</td>
                                <td>
                                    2019-08-18
                            </td>
                                <td>146</td>
                            </tr>
                        })}


                    </tbody>
                </table>
            </div>

            <div className="indexer margin-top align-right">
                <h3 className="hidden">현재 페이지</h3>
                <div><span className="text-orange text-strong">1</span> / 1 pages</div>
            </div>

            <Pager page={this.state.curPage}
                count={this.state.count}
                onPageClick={this.pagerClick.bind(this)} />
        </main>

        );
    }
}

export default List;
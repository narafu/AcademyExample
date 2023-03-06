import React, { Component } from 'react';

class Pager extends Component {

    constructor(props){
        super(props);

        let {page, count, onPageClick} = props;        

        this.state = {
            nums:[1,2,3,4,5],
            count,
            page,
            onPageClick
        };

        console.log(this.state);
    }    
    pageClick(e){
        e.preventDefault();
        console.log(e.target);
        let n = e.target.innerText;
        //console.log(n);
        this.props.onPageClick({num:n});
    }
    render() {

        let pages = this.state
                    .nums
                    .map(n=><li>
                                <a className={11} 
                                    href="?p={n}&F=&q=" 
                                    onClick={this.pageClick.bind(this)}>
                                    {n}
                                </a>
                            </li>);

        return (
            <div className="margin-top align-center pager">

                <div>
                    <span className="btn btn-prev">이전</span>
                </div>
                <ul className="-list- center">
                    {pages}                    
                </ul>
                <div>
                    <span className="btn btn-next" >다음</span>

                </div>

            </div>
        );
    }
}

export default Pager;
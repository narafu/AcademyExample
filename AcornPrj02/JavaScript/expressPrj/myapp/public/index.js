class Calc extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            x: '0',
            y: '0',
            result: '0',
        };
    }
    btnClick() {
        this.setState({ x: 0, y: 0 });
    }
    render() {
        return (
            <section>
                <h1>계산기 프로그램</h1>
                <div>
                    <input
                        type="text"
                        dir="rtl"
                        value={this.state.x}
                        onInput={(e) => {
                            this.setState({ x: e.target.value });
                        }}
                    />
                    <input
                        type="text"
                        dir="rtl"
                        value={this.state.y}
                        onInput={(e) => {
                            this.setState({ y: e.target.value });
                        }}
                    />
                    <input
                        type="button"
                        value="계산"
                        onClick={this.btnClick.bind(this)}
                    />
                    <input type="text" dir="rtl" value={this.state.result} readOnly />
                </div>
            </section>
        );
    }
}
ReactDOM.render(<Calc />, document.getElementById('root'));
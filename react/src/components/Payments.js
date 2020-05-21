import React from "react";
import Menu from "./Menu";
import Header from "./Header";
import Footer from "./Footer";

class Payments extends React.Component {

    constructor() {
        super();
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.state = {
            receiverName: '',
            receiverAccount: '',
            amount: '',
            invoice: '',
            comment: ''
        };

    }

    receiverNameChangeHandler = (event) => {
        this.setState({receiverName: event.target.value});
    }

    receiverAccountChangeHandler = (event) => {
        this.setState({receiverAccount: event.target.value});
    }

    amountChangeHandler = (event) => {
        this.setState({amount: event.target.value});
    }

    invoiceChangeHandler = (event) => {
        this.setState({invoice: event.target.value});
    }

    commentChangeHandler = (event) => {
        this.setState({comment: event.target.value});
    }

    handleSubmit(event) {
        event.preventDefault();

        const requestOptions = {
            headers: { 'Content-Type': 'application/json',  'Authorization': 'Basic cmVlbWV0OnBhcm9vbA=='}
        };

        fetch('http://localhost:8080/payments/process', {
            headers: { 'Content-Type': 'application/json', 'Authorization': 'Bearer ' + localStorage.getItem("token")},
            method: 'POST',
            body: JSON.stringify({
                receiverName: this.state.receiverName,
                receiverAccount: this.state.receiverAccount,
                amount: this.state.amount,
                invoice: this.state.invoice,
                comment: this.state.comment

            })

        });
    }

    render() {

        return (
            <div>
                <Header />
                <Menu />

                <div id="paymentcontent">

                    <form onSubmit={this.handleSubmit}>
                        <h2>Makse</h2>

                        <div className="input-container">
                            <i className="fa fa-user icon"></i>
                            <input className="input-field" type="text" placeholder="Saaja nimi" name="receiverName" onChange={this.receiverNameChangeHandler}/>
                        </div>

                        <div className="input-container">
                            <i className="fa fa-book icon"></i>
                            <input className="input-field" type="text" placeholder="Saaja konto" name="receiverAccount" onChange={this.receiverAccountChangeHandler}/>
                        </div>

                        <div className="input-container">
                            <i className="fa fa-euro-sign icon"></i>
                            <input className="input-field" type="text" placeholder="Summa" name="amount" onChange={this.amountChangeHandler}/>
                        </div>

                        <div className="input-container">
                            <i className="fa fa-credit-card icon"></i>
                            <input className="input-field" type="text" placeholder="Viitenumber" name="invoice" onChange={this.invoiceChangeHandler}/>
                        </div>

                        <div className="input-container">
                            <i className="fa fa-comment icon"></i>
                            <input className="input-field" type="text" placeholder="Kommentaar" name="comment" onChange={this.commentChangeHandler}/>
                        </div>

                        <button type="submit" className="btn">Maksa</button>
                    </form>

                </div>

                <Footer />
            </div>
        );
    }

}
export default Payments;
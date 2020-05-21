import React from "react";
import Menu from "./Menu";
import Header from "./Header";
import Footer from "./Footer";

class History extends React.Component {

    state = {
        isLoading: true,
        transactions: []
    };
    async componentDidMount() {

        const requestOptions = {
            method: 'GET',
            headers: { 'Content-Type': 'application/json', 'Authorization': 'Bearer ' + localStorage.getItem("token")}
        };

        const response = await fetch('http://localhost:8080/payments/show', requestOptions);
        const body = await response.json();
        this.setState({ transactions: body, isLoading: false });
    }

    render() {

        const {transactions, isLoading} = this.state;

        return (
            <div>
                <Header />
                <Menu />

                <div id="historycontent">

                    <table>
                        <tr>
                            <th>Saatja</th>
                            <th>Saaja</th>
                            <th>Saatja konto</th>
                            <th>Saaja konto</th>
                            <th>Summa</th>
                            <th>Viitenumber</th>
                            <th>Kommentaar</th>
                            <th>Kuupäev</th>
                        </tr>

                        {transactions.map(transaction =>
                            <tr key={transaction.id}>
                                <td>{transaction.sender.firstName} {transaction.sender.lastName}</td>
                                <td>{transaction.receiver == null ? "n/a" : transaction.receiver.firstName + " " + transaction.receiver.lastName}</td>
                                <td>{transaction.senderAccount.accountNumber}</td>
                                <td>{transaction.receiverAccount == null ? "n/a" : transaction.receiverAccount.accountNumber}</td>
                                <td>{transaction.amount}</td>
                                <td>{transaction.invoice}</td>
                                <td>{transaction.comment}</td>
                                <td>{transaction.sendDateTime}</td>

                            </tr>
                        )}

                    </table>

                </div>

                <Footer />
            </div>
        )

    }

}

export default History;
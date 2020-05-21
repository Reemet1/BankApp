import React from "react";
import Menu from "./Menu";
import Header from "./Header";
import Footer from "./Footer";

class Cards extends React.Component {

    state = {
        isLoading: true,
        cards: []
    };
    async componentDidMount() {
        const encoded = new Buffer('reemet:parool').toString('base64')
        const headers = { 'Authorization': 'Basic ' + encoded, 'method':'GET'}

        const requestOptions = {
            method: 'GET',
            headers: { 'Content-Type': 'application/json', 'Authorization': 'Bearer ' + localStorage.getItem("token")}
        };

        const response = await fetch('http://localhost:8080/cards/get', requestOptions);
        const body = await response.json();
        this.setState({ cards: body, isLoading: false });
    }

    render() {

        const {cards, isLoading} = this.state;

        return (
            <div>
                <Header />
                <Menu />

                <div id="cardscontent">
                    <table>
                        <tr>
                            <th>Kaarti number</th>
                            <th>Seotud konto</th>
                            <th>Kehtib kuni</th>
                        </tr>

                        {cards.map(card =>
                            <tr key={card.id}>
                                <td>{card.cardNumber}</td>
                                <td>{card.account}</td>
                                <td>{card.validUntil}</td>
                            </tr>
                        )}

                    </table>

                    <a href="/addcard">Lisa kaart</a>

                </div>

                <Footer />
            </div>
        )

    }

}

export default Cards;
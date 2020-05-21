import React from "react";
import Menu from "./Menu";
import Header from "./Header";
import Footer from "./Footer";

class Accounts extends React.Component {

    state = {
        isLoading: true,
        accounts: []
    };
    async componentDidMount() {

        const requestOptions = {
            method: 'GET',
            headers: { 'Content-Type': 'application/json', 'Authorization': 'Bearer ' + localStorage.getItem("token")}
        };

        const response = await fetch('http://localhost:8080/accounts/get', requestOptions);
        const body = await response.json();
        this.setState({ accounts: body, isLoading: false });
    }


    render() {

        const {accounts, isLoading} = this.state;
        return (
            <div>

                <Header />
                <Menu />


                <div id="accountscontent">
                    <table>
                        <tr>
                            <th>Arvelduskonto</th>
                            <th>Vabad vahendid</th>
                            <th>Lisainfo</th>
                        </tr>

                        {accounts.map(account =>
                            <tr key={account.id}>
                                <td>{account.accountNumber}</td>
                                <td>{account.balance}</td>
                                <td></td>
                            </tr>
                        )}

                    </table>

                    <a href="/addaccount">Lisa konto</a>

                </div>

                <Footer />
            </div>
        )

    }

}

export default Accounts;
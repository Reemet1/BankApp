import React from "react";
import Menu from "./Menu";
import Header from "./Header";
import Footer from "./Footer";

class AddCard extends React.Component {

    render() {

        return (
            <div>
                <Header />
                <Menu />

                <div id="cardscontent">

                    <form action="${pageContext.request.contextPath}/cards/addCard" modelAttribute="cardForm">
                        Kaarti number: <input path="cardNumber" />
                        <br/><br/>
                        Konto:
                        <select path="accountId">

                        </select>
                        <input type="submit" value="Submit" />

                    </form>

                </div>

                <Footer />
            </div>
        )

    }

}

export default AddCard;
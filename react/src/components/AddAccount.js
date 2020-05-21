import React from "react";
import Menu from "./Menu";
import Header from "./Header";
import Footer from "./Footer";

class AddAccount extends React.Component {

    render() {

        return (
            <div>
                <Header />
                <Menu />

                <div id="accountscontent">

                    <form action="${pageContext.request.contextPath}/accounts/addAccount" modelAttribute="accountForm">
                        Konto number: <input path="accountNumber" />
                        <br/><br/>
                        Krediit:
                        <input path="startingBalance" />

                        <br/>

                        <input type="submit" value="Submit" />

                    </form>

                </div>

                <Footer />
            </div>
        )

    }

}

export default AddAccount;
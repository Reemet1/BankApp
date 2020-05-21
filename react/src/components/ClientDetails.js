import React from "react";
import Menu from "./Menu";
import Header from "./Header";
import Footer from "./Footer";

class ClientDetails extends React.Component {

    state = {
        isLoading: true,
        clientDetails: {}
    };
    async componentDidMount() {
        const encoded = new Buffer('reemet:parool').toString('base64')
        const headers = { 'Authorization': 'Basic ' + encoded, 'method':'GET'}

        const requestOptions = {
            method: 'GET',
            headers: { 'Content-Type': 'application/json', 'Authorization': 'Bearer ' + localStorage.getItem("token")}
        };

        const response = await fetch('http://localhost:8080/client/details', requestOptions);
        const body = await response.json();
        this.setState({ clientDetails: body, isLoading: false });
    }

    render() {

        const {clientDetails, isLoading} = this.state;

        return (
            <div>
                <Header />
                <Menu />

                <div id="clientdetailscontent">

                    <form action="${pageContext.request.contextPath}/client/update" modelAttribute="clientDetails">

                        Eesnimi: <input path="firstName" value={clientDetails.firstName}/>
                        <br/><br/>
                        Perenimi: <input path="lastName" value={clientDetails.lastName}/>

                        <br/><br/>
                        Isikukood: <input path="personalId" value={clientDetails.personalId} />

                        <br/><br/>
                        Sünniaeg: <input path="dateOfBirth" value={clientDetails.dateOfBirth} />

                        <br/><br/>
                        Aadress1: <input path="address1" value={clientDetails.address1} />

                        <br/><br/>
                        Aadress2: <input path="address2" value={clientDetails.address2} />

                        <br/><br/>
                        Telefon: <input path="phoneNumber" value={clientDetails.phoneNumber} />

                        <br/><br/>
                        Email: <input path="email" value={clientDetails.email} />


                        <br/><br/>

                        <input type="submit" value="Submit" />

                    </form>

                </div>

                <Footer />
            </div>
        )

    }

}

export default ClientDetails;
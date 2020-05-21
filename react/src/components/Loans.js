import React from "react";
import Menu from "./Menu";
import Header from "./Header";
import Footer from "./Footer";

class Loans extends React.Component {

    render() {

        return (
            <div>
                <Header />
                <Menu />

                <div id="loanscontent">

                    <table>
                        <tr>
                            <th>Laenu tüüp</th>
                            <th>Laenusumma</th>
                            <th>Intress</th>
                            <th>Tagasimakse aeg</th>
                            <th>Tagasimakstav summa</th>
                            <th>Kuumakse</th>
                            <th>Algus kuupäev</th>
                            <th>Lõppkuupäev</th>
                        </tr>

                    </table>

                    <br/><br/>

                    <form action="${pageContext.request.contextPath}/loans/take" modelAttribute="loan">

                        Laenutüüp:
                        <select path="type">
                            <option value="consumer_loan">Väikelaen</option>
                            <option value="car_loan">Autolaen</option>
                            <option value="home_loan">Kodulaen</option>
                        </select>

                        <br/><br/>

                        Laenusumma: <input path="loanAmount" />
                        <br/><br/>

                        Tagasimakse aeg (kuud): <input path="totalPaybackTime" />
                        <br/><br/>

                        <input type="submit" value="Submit" />

                    </form>

                </div>

                <Footer />
            </div>
        )

    }

}

export default Loans;
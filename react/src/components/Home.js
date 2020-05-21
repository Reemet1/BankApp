import React from "react";
import Menu from "./Menu";
import Header from "./Header";
import Footer from "./Footer";

class Home extends React.Component {

    render() {

        return (
            <div>
                <Header />
                <Menu />

                <div id="homecontent">
                    <table>
                        <tr>
                            <th>Arvelduskonto</th>
                            <th>Vabad vahendid</th>
                        </tr>


                    </table>
                </div>

                <Footer />
            </div>
        );
    }

}
export default Home;
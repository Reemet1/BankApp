import React from "react";
import Menu from "./Menu";
import Header from "./Header";
import Footer from "./Footer";

class Documents extends React.Component {

    render() {

        return (
            <div>
                <Header />
                <Menu />

                <div id="content">

                    <a href="/documents/download">Loe dokumenti</a>

                </div>

                <Footer />
            </div>
        )

    }

}

export default Documents;
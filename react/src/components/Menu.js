import React from "react";

class Menu extends React.Component {

    render() {

        return (
            <div>
                <ul id="menu">
                    <li><a href="/home"><i className="fa fa-home icon"></i>Pealeht</a></li>
                    <li><a href="/payments"><i className="fa fa-credit-card icon"></i>Maksed</a></li>
                    <li><a href="/history"><i className="fa fa-list-alt icon"></i>Väljavõte</a></li>
                    <li><a href="/accounts"><i className="fa fa-book icon"></i>Kontod</a></li>
                    <li><a href="/cards"><i className="fa fa-credit-card icon"></i>Kaardid</a></li>
                    <li><a href="/loans"><i className="fa fa-suitcase icon"></i>Laenud</a></li>
                    <li><a href="/documents"><i className="fa fa-credit-card icon"></i>Lepingud</a></li>
                    <li><a href="/clientdetails"><i className="fa fa-address-card icon"></i>Profiil</a></li>
                    <li><a href="/statistics"><i className="fa fa-address-card icon"></i>Statistika</a></li>
                </ul>
            </div>
        );
    }

}
export default Menu;
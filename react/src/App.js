import React from 'react';
import logo from './logo.svg';
import './App.css';

import {BrowserRouter as Router, Route, Switch, Link, Redirect} from "react-router-dom"

import Home from "./components/Home";
import Payments from "./components/Payments";
import History from "./components/History";
import Accounts from "./components/Accounts";
import Cards from "./components/Cards";
import Loans from "./components/Loans";
import Documents from "./components/Documents";
import ClientDetails from "./components/ClientDetails";
import AddAccount from "./components/AddAccount";
import AddCard from "./components/AddCard";
import User from "./components/User";
import TestForm from "./components/TestForm";
import Register from "./components/Register";
import Login from "./components/Login";
import Statistics from "./components/Statistics";


class App extends React.Component {



  render() {


    return (
        <Router>
            <Switch>
                <Route exact path="/home" component={Home}></Route>
                <Route exact path="/payments" component={Payments}></Route>
                <Route exact path="/history" component={History}></Route>
                <Route exact path="/accounts" component={Accounts}></Route>
                <Route exact path="/cards" component={Cards}></Route>
                <Route exact path="/loans" component={Loans}></Route>
                <Route exact path="/documents" component={Documents}></Route>
                <Route exact path="/clientdetails" component={ClientDetails}></Route>
                <Route exact path="/addaccount" component={AddAccount}></Route>
                <Route exact path="/addcard" component={AddCard}></Route>
                <Route exact path="/users" component={User}></Route>
                <Route exact path="/form" component={TestForm}></Route>
                <Route exact path="/register" component={Register}></Route>
                <Route exact path="/" component={Login}></Route>
                <Route exact path="/statistics" component={Statistics}></Route>
            </Switch>
        </Router>
    );
  }

}


export default App;

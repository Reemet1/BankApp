import React from "react";
import Menu from "./Menu";
import Header from "./Header";
import Footer from "./Footer";

class Register extends React.Component {

    constructor() {
        super();
        this.handleSubmit = this.handleSubmit.bind(this);
        this.state = {
            firstName: '',
            lastName: '',
            email: '',
            username: '',
            password: ''
        };
    }

    firstNameChangeHandler = (event) => {
        this.setState({firstName: event.target.value});
    }

    lastNameChangeHandler = (event) => {
        this.setState({lastName: event.target.value});
    }

    emailChangeHandler = (event) => {
        this.setState({email: event.target.value});
    }

    usernameChangeHandler = (event) => {
        this.setState({username: event.target.value});
    }

    passwordChangeHandler = (event) => {
        this.setState({password: event.target.value});
    }

    handleSubmit(event) {
        event.preventDefault();

        const requestOptions = {
            headers: { 'Content-Type': 'application/json',  'Authorization': 'Basic cmVlbWV0OnBhcm9vbA=='}
        };

        fetch('http://localhost:8080/api/auth/signup', {
            headers: { 'Content-Type': 'application/json'},
            method: 'POST',
            body: JSON.stringify({
                firstName: this.state.firstName,
                lastName: this.state.firstName,
                email: this.state.email,
                username: this.state.username,
                password: this.state.password
            })
        }).then(resp => resp.json())
            .then(data => {
                if (data.message) {
                    window.alert(data.message)
                } else {
                    localStorage.setItem("token", data.jwt)
                    window.alert(data.message)
                }
            })
    }


    render() {

        const {accounts, isLoading} = this.state;
        return (
            <div>

                <form id="registrationForm" onSubmit={this.handleSubmit}>
                    <h2>Registreerimine</h2>

                    <div className="input-container">
                        <i className="fa fa-user icon"></i>
                        <input className="input-field" type="text" placeholder="Eesnimi" name="firstName"  onChange={this.firstNameChangeHandler}/>

                    </div>

                    <div className="input-container">
                        <i className="fa fa-user icon"></i>
                        <input className="input-field" type="text" placeholder="Perenimi" name="lastName"  onChange={this.lastNameChangeHandler}/>

                    </div>

                    <div className="input-container">
                        <i className="fa fa-envelope icon"></i>
                        <input className="input-field" type="text" placeholder="Email" name="email"  onChange={this.emailChangeHandler}/>

                    </div>

                    <div className="input-container">
                        <i className="fa fa-user icon"></i>
                        <input className="input-field" type="text" placeholder="Kasutajanimi" name="username"  onChange={this.usernameChangeHandler}/>

                    </div>

                    <div className="input-container">
                        <i className="fa fa-lock icon"></i>
                        <input className="input-field" type="password" placeholder="Parool" name="password"  onChange={this.passwordChangeHandler}/>

                    </div>

                    <button className="btn">Registreeri</button>
                </form>

            </div>
        )

    }

}

export default Register;
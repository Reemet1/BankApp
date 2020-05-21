import React from "react";
import Menu from "./Menu";
import Header from "./Header";
import Footer from "./Footer";

class Login extends React.Component {

    constructor() {
        super();
        this.handleSubmit = this.handleSubmit.bind(this);
        this.state = {
            username: '',
            password: ''
        };
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
        const { history } = this.props;

        fetch('http://localhost:8080/api/auth/signin', {
            headers: { 'Content-Type': 'application/json'},
            method: 'POST',
            body: JSON.stringify({
                usernameOrEmail: this.state.username,
                password: this.state.password
            })
        }).then(resp => resp.json())
            .then(data => {
                if (data.message) {
                    //window.alert(data.message)
                } else {
                    localStorage.setItem("token", data.accessToken);
                    history.push('/home');
                }
            })
    }


    render() {

        const {accounts, isLoading} = this.state;
        return (
            <div>

                <form id="loginForm" onSubmit={this.handleSubmit}>
                    <h2>Sisselogimine</h2>
                    <div className="input-container">
                        <i className="fa fa-user icon"></i>
                        <input className="input-field" type="text" placeholder="Kasutajanimi" name="username"   onChange={this.usernameChangeHandler}/>
                    </div>

                    <div className="input-container">
                        <i className="fa fa-lock icon"></i>
                        <input className="input-field" type="password" placeholder="Parool" name="password"   onChange={this.passwordChangeHandler}/>
                    </div>

                    <button type="submit" className="btn">Logi sisse</button>
                    <a href="/registration/show">Registreeri kasutajaks</a>
                </form>

            </div>
        )

    }

}

export default Login;
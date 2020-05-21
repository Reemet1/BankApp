import React from "react";

class TestForm extends React.Component {

    constructor() {
        super();
        this.handleSubmit = this.handleSubmit.bind(this);
        this.state = { username: '' };
        this.state = { email: '' };
    }

    usernameChangeHandler = (event) => {
        this.setState({username: event.target.value});
    }

    emailChangeHandler = (event) => {
        this.setState({email: event.target.value});
    }

    handleSubmit(event) {
        event.preventDefault();

        const requestOptions = {
            headers: { 'Content-Type': 'application/json',  'Authorization': 'Basic cmVlbWV0OnBhcm9vbA=='}
        };

        fetch('http://localhost:8080/test/form', {
            headers: { 'Content-Type': 'application/json',  'Authorization': 'Basic cmVlbWV0OnBhcm9vbA=='},
            method: 'POST',
            body: JSON.stringify({
                username: this.state.username,
                email: this.state.email,
            })

        });
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label htmlFor="username">Enter username</label>
                <input id="username" name="username" type="text" onChange={this.usernameChangeHandler} />

                <label htmlFor="email">Enter your email</label>
                <input id="email" name="email" type="email" onChange={this.emailChangeHandler} />

                <button>Send data!</button>
            </form>
        );
    }

}
export default TestForm;
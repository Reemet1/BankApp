import React from "react";

class User extends React.Component {

    state = {
        isLoading: true,
        users: []
    };
    async componentDidMount() {
        const headers = { 'Authorization': 'Basic cmVlbWV0OnBhcm9vbA=='}
        const response = await fetch('http://localhost:8080/api/person', { headers });
        const body = await response.json();
        this.setState({ users: body, isLoading: false });
    }


    render() {

        const {users, isLoading} = this.state;

        return (
            <div>
                <div className="App-intro">
                    <h2>JUG List</h2>
                    {users.map(user =>
                        <div key={user.id}>
                            {user.firstName}
                        </div>
                    )}
                </div>
            </div>
        );
    }

}
export default User;
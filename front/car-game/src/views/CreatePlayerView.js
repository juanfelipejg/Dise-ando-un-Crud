import React, {useState} from 'react'

const HOST_API = "http://localhost:8080/api"

function CreatePlayerView(props)  {

    console.log(props.numbersOfPlayers)

    const [numberOfPlayers, setPlayers] = React.useState(props.numbersOfPlayers);


    const create = (event) => {

        event.preventDefault();

        const request = {
            players: numberOfPlayers
        }

        fetch(`${HOST_API}/player`, {
            method: "POST",
            body: JSON.stringify(request),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then(response => {
                console.log(response)
                //ReactDOM.render(<StartGameView />, document.getElementById("app-container"))
            })

    }

    const submitForm = (event) =>{       

        setPlayers({...numberOfPlayers, [event.target.name]: event.target.value})
    }

    

    const Field = ({id}: {id: number}) => (
        <div className="mb-3">
        <label className="form-label">Jugador</label>
        <input type="text" className="form-control" id = {`player${id}`} onChange={submitForm}></input>
        </div>
    );

    const fields: JSX.Element[] = [];
    for (let i = 1; i <= numberOfPlayers; i++) {
      fields.push(<Field id={i} key={i} />);
    }

    const startGame = (event) => {

        event.preventDefault();

        console.log(numberOfPlayers);
    };     

    return(
        <div className="container p-3 form-container">
            <form onSubmit = {startGame}>
                {console.log(fields)}
                <div className = "button-container">
                    <button type = "submit" className="btn btn-primary" onClick={create}>Empezar Juego</button>
                </div>
            </form>
        </div>
    )

}


export default CreatePlayerView
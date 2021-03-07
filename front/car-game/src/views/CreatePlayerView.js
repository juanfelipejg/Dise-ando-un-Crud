import React, {useState}  from 'react'

const HOST_API = "http://localhost:8080/api"

function CreatePlayerView({numPlayers})  {

    const [players, setPlayers] = useState([]);

    const create = (event) => {

        event.preventDefault();

        players.forEach(element => {

            const request = {
                name: element.name
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
                //ReactDOM.render(<StartGameView />, document.getElementById("app-container"))
            })

        })

    }

    function submitForm (event) {
        setPlayers([...players, {name: event.target.value}])
    }  
    
    const Field = ({id}: {id: number}) => (
        <div className="mb-3">
        <label className="form-label">Jugador</label>        
        <input type="text" className="form-control" id={`player${id}`} onBlur={(event) => {submitForm(event)}}></input>
        </div>
    )

    const fields: JSX.Element[] = [];
    for (let i = 1; i <= numPlayers; i++) {
      fields.push(<Field id={i} key={i} />);
    }   

    return(
        <div className="container p-3 form-container">
            <form>
                {fields}
                <div className = "button-container">
                    <button type = "submit" className="btn btn-primary" onClick={create}> Empezar Juego </button>
                </div>
            </form>
        </div>
    )
}

export default CreatePlayerView
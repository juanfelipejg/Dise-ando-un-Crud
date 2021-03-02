import React from 'react'

const CreatePlayerView = () =>{

    return(
        <div className="container p-3 form-container">
            <form>
                <div className="mb-3">
                    <label className="form-label">Jugador 1</label>
                    <input type="text" className="form-control" id="players"></input>
                </div>
                <div className="mb-3">
                    <label className="form-label">Jugador 2</label>
                    <input type="text" className="form-control" id="distance"></input>
                </div>
                <div className="mb-3">
                    <label className="form-label">Jugador 3</label>
                    <input type="text" className="form-control" id="distance"></input>
                </div>
                <div className = "button-container">
                    <button className="btn btn-primary">Enviar</button>
                </div>
            </form>
        </div>
    )

}

export default CreatePlayerView
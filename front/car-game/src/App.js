import './App.css';
import CreateGameView from './views/CreateGameView'
import CreatePlayerView from './views/CreatePlayerView'

function App() {
    return (
        <div className = "container p-4">
            <h3 className = "centered">¡Juego De Carros!</h3>
            <CreateGameView />
            <CreatePlayerView />
        </div>       
    )
}

export default App;

document.addEventListener('DOMContentLoaded', function() {
    const cells = document.querySelectorAll('.cell');
    const messageElement = document.getElementById('message');
    const resetButton = document.getElementById('resetButton');

    let currentPlayer = 'X';
    let gameInProgress = true;

    cells.forEach(cell => {
        cell.addEventListener('click', () => {
            if (!gameInProgress || cell.textContent !== '') return;

            cell.textContent = currentPlayer;
            cell.classList.add(currentPlayer === 'X' ? 'x' : 'o');

            // Send API request to save game state
            saveGameState(cell.id.split('-')[1], currentPlayer);

            if (checkWin()) {
                messageElement.textContent = `${currentPlayer} wins!`;
                gameInProgress = false;
            } else if (checkDraw()) {
                messageElement.textContent = 'It\'s a draw!';
                gameInProgress = false;
            } else {
                currentPlayer = currentPlayer === 'X' ? 'O' : 'X';
                messageElement.textContent = `Player ${currentPlayer}'s turn`;
            }
        });
    });

    resetButton.addEventListener('click', () => {
        resetGame();
    });

    function checkWin() {
        const winningConditions = [
            [0, 1, 2], [3, 4, 5], [6, 7, 8], // rows
            [0, 3, 6], [1, 4, 7], [2, 5, 8], // columns
            [0, 4, 8], [2, 4, 6] // diagonals
        ];

        return winningConditions.some(condition => {
            const [a, b, c] = condition;
            return cells[a].textContent !== '' &&
                cells[a].textContent === cells[b].textContent &&
                cells[a].textContent === cells[c].textContent;
        });
    }

    function checkDraw() {
        return [...cells].every(cell => cell.textContent !== '');
    }

    function resetGame() {
        cells.forEach(cell => {
            cell.textContent = '';
            cell.classList.remove('x', 'o');
        });

        currentPlayer = 'X';
        gameInProgress = true;
        messageElement.textContent = `Player ${currentPlayer}'s turn`;
    }

    function saveGameState(cellIndex, currentPlayer) {
        fetch('http://localhost:8080/saveState', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                stateData: {
                    status: 'IN_PROGRESS', // or other relevant status
                    state: [{
                        ind: parseInt(cellIndex),
                        value: currentPlayer
                    }]
                }
            }),
        })
        .then(response => response.json())
        .then(data => {
            console.log('Saved state:', data);
        })
        .catch(error => {
            console.error('Error:', error);
        });
    }

    // Fetch and display game state when the page loads
    fetch('http://localhost:8080/getAllState')
        .then(response => response.json())
        .then(data => {
            if (data.length > 0) {
                const lastState = data[0];
                lastState.state.forEach(gameState => {
                    const cell = document.getElementById(`cell-${gameState.ind}`);
                    cell.textContent = gameState.value;
                    cell.classList.add(gameState.value === 'X' ? 'x' : 'o');
                });
            }
        })
        .catch(error => {
            console.error('Error fetching state:', error);
        });
});


    // Fetch and display last 10 games
    fetch('http://localhost:8080/getAllState')
        .then(response => response.json())
        .then(data => {
            if (data.length > 0) {
                data.forEach(game => {
                    const gameElement = document.createElement('div');
                    gameElement.textContent = `Game ${game.id}: ${game.status}`;
                    lastGamesElement.appendChild(gameElement);
                });
            }
        })
        .catch(error => {
            console.error('Error fetching last 10 games:', error);
        });

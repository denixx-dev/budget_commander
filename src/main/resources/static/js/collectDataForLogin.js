document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const jsonData = {};
    formData.forEach((value, key) => { jsonData[key] = value });

    fetch('/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonData)
    })
    .then(response => {
        if (!response.ok) {
            showErrorBox();
            setTimeout(hideErrorBox, 3000);
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        console.log(data); // Обработка успешного ответа
        window.location.href = '/auth/userData';
    })
    .catch(error => {
        console.error('Error:', error); // Обработка ошибки
    });
});

function showErrorBox() {
    var error_box = document.getElementById('error_box');
    error_box.style.display = 'block';
    setTimeout(function() {
        error_box.style.opacity = '1';
    }, 1); // Задержка перед появлением
}

function hideErrorBox() {
    var error_box = document.getElementById('error_box');
    error_box.style.display = 'none';
    setTimeout(function() {
        error_box.style.opacity = '0';
    }, 3000); // Задержка перед появлением
}
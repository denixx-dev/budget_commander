document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const jsonData = {};
    formData.forEach((value, key) => { jsonData[key] = value });

    fetch('/auth/register', {
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
        showSuccessBox();
        setTimeout(hideSuccessBox, 3000);
        return response.json();
    })
    .then(data => {
        console.log(data); // Обработка успешного ответа
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

function showSuccessBox() {
    var success_box = document.getElementById('success_box');
    success_box.style.display = 'block';
    setTimeout(function() {
        success_box.style.opacity = '1';
    }, 1); // Задержка перед появлением
}

function hideSuccessBox() {
    var success_box = document.getElementById('success_box');
    success_box.style.display = 'none';
    setTimeout(function() {
        success_box.style.opacity = '0';
    }, 3000); // Задержка перед появлением
}
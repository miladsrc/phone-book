document.getElementById('addUserForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const formData = new FormData(this);

    fetch('/api/users/add', {
        method: 'POST',
        body: formData
    })
        .then(response => response.json())
        .then(data => {
            alert('User added successfully!');
            window.location.reload();  // Reload the page to reflect changes
        })
        .catch(error => {
            alert('Error adding user');
            console.error('Error:', error);
        });
});

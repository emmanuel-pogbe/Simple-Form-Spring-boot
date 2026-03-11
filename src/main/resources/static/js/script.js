document.addEventListener("DOMContentLoaded", () => {
    const submitBtn = document.getElementById("submit-btn");

    submitBtn.addEventListener("click", (e) => {
        e.preventDefault();
        
        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;
        const payload = {
            email: email,
            password: password
        };

        fetch("/", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(payload)
        })
        .then(response => response.json())
        .then(result => {
            if (result.isLoggedIn) {
                window.location.href = "/success?email=" + encodeURIComponent(email);
            } else {
                const errorMsg = document.getElementById("failed-credentials-trigger");
                errorMsg.style.visibility = "visible";
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
    });
});
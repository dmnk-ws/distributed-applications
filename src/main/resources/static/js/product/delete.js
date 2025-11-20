const deleteButtons = window.document.querySelectorAll('button[id^="delete-"]');

deleteButtons.forEach((deleteButton) => {
    deleteButton.addEventListener("click", () => {
        const productId = deleteButton.id.replace('delete-', '');
        const id = window.document.getElementById(`id-${productId}`).value;

        fetch(`/rest/products/delete/${id}`, {
            method: "DELETE",
        })
        .then((response) => {
            if (!response.ok) {
                throw new Error("Product could not be deleted")
            }

            alert(`Product was successfully deleted`);
            window.location.replace("/mvc/products?edit=true");
        })
        .catch((error) => console.log(error))
    });
});
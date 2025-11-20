const colorFilter = window.document.getElementById("color-filter");
const urlParams = new URLSearchParams(window.location.search);
const colorParam = urlParams.get('color');
const colors = ["all", "black", "red", "blue"];

if (colors.includes(colorParam)) {
    colorFilter.value = colorParam;
}

colorFilter.addEventListener("change", () => {
    window.location.href = `/mvc/products/filter?color=${colorFilter.value}`;
});


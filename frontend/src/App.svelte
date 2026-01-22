<script>
    import { onMount } from 'svelte';

    let products = [];
    let error = null;
    const catalogUrl = 'http://localhost:8080/saas/catalog/';
    const apiKey = 'super-secret-api-key';
    const tenantId = 'shop-123';

    async function fetchProducts() {
        try {
            const response = await fetch(catalogUrl, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'X-API-KEY': apiKey,
                    'TENANT-ID': tenantId,
                },
            });

            if (!response.ok) {
                throw new Error(`Error fetching products: ${response.statusText}`);
            }

            products = await response.json();
        } catch (err) {
            error = err.message;
        }
    }

    onMount(() => {
        fetchProducts();
    });
</script>

<main>
    <h1>Product Catalog</h1>
    {#if error}
        <p class="error">{error}</p>
    {:else if products.length === 0}
        <p>Loading products...</p>
    {:else}
        <div>
            {#each products as product}
                <div>
                    <span>{product.name}</span>
                    <span>{product.price}</span>
                    <span>{product.color}</span>
                    <span>{product.size}</span>
                </div>
            {/each}
        </div>
    {/if}
</main>

<style>
    main {
        padding: 50px;
    }

    .error {
        color: red;
    }
</style>
<template>
  <header>
    <nav>
      <div class="nav-wrapper container custom-navbar">
        <a href="#" class="brand-logo"
          ><img class="logo" src="../assets/logo.png"
        /></a>
        <div class="input-field custom-form">
          <input
            placeholder="O que você está procurando?"
            id="search"
            type="search"
          />
        </div>
        <!-- Dropdown Trigger -->
        <a class="dropdown-trigger custom-btn-account" href="#" data-target="dropdown1">Minha Conta</a>
        <!-- Dropdown Structure -->
        <ul id="dropdown1" class="dropdown-content">
          <li><a href="#!">Login</a></li>
          <li><a href="#!">Registrar</a></li>
          <li class="divider" tabindex="-1"></li>
          <li><a href="#!">Adicionar produto</a></li>
        </ul>

        <i class="material-icons shopping-cart">shopping_cart</i>
      </div>

      <div class="nav-wrapper secondary-nav">
        <div class="container sub-nav">
          <ul id="nav-mobile" class="left hide-on-med-and-down">
            
            
            <!-- Dropdown Trigger -->
            <li><a class="dropdown-trigger custom-btn" href="#" data-target="dropdown2">Todas categorias</a>
            <!-- Dropdown Structure -->
            <ul id="dropdown2" class="dropdown-content">
              <li><a href="#!">Login</a></li>
              <li><a href="#!">Registrar</a></li>
              <li class="divider" tabindex="-1"></li>
              <li><a href="#!">Adicionar produto</a></li>
            </ul>
            </li>
            <li><a class="custom-btn" href="sass.html">Produtos</a></li>
            <li><a class="custom-btn" href="collapsible.html">Sobre-nós</a></li>
          </ul>
        </div>
      </div>
    </nav>
  </header>
</template>

<script>
import M from "materialize-css/dist/js/materialize.min.js";

export default {
  name: "header-app",
  mounted() {
    M.AutoInit();
  },
};

document.addEventListener("DOMContentLoaded", function () {
  var elems = document.querySelectorAll(".dropdown-trigger");
  M.Dropdown.init(elems, { coverTrigger: false, hover: true });
});
</script>


<style scoped>
nav {
  background: var(--navbar-color);
  font-family: var(--font-base);
  height: 100px;

}
.custom-navbar {
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.custom-navbar .brand-logo {
  position: relative;
}
.logo {
  width: auto;
  margin-top: 10px;
  height: 80px;
}
.custom-form {
  height: 40px;
  width: 600px;
}
.custom-form input[type="search"]:not(.browser-default) {
  border-radius: 20px;
  border-bottom: #fdba337a 0.5px solid;
}
.custom-btn-account {
  font-size: 20px;
}
.custom-btn-account,.custom-btn:focus-visible {
  outline: none;
}
.dropdown-content {
  min-width: 170px;
}
.dropdown-content a {
  color: #000;
}
.shopping-cart {
  font-size: 40px;
  color: var(--complementary-color);
}

.secondary-nav {
  background: var(--sub-navbar-color);
  height: 50px;
}
.sub-nav{
  height:100%;
  display: flex;
  align-items: center
}
.sub-nav .custom-btn {
  font-weight: bold;
  color: black;
  height: 30px;
  display: flex;
  align-items: center;  
}
.sub-nav .custom-btn:hover {
  background: none;
  color: #b9b9b9;  
}
</style>
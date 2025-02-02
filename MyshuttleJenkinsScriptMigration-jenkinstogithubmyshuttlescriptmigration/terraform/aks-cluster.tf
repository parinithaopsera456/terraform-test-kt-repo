provider "azurerm" {
  features {}
}

resource "azurerm_resource_group" "default" {
  name     = var.resource-groupname
  location = "Southeast Asia"

  tags = {
    environment = "Demo"
  }
}

resource "azurerm_kubernetes_cluster" "default" {
  name                = "${var.cluster-name}-${var.env-name}"
  location            = "Southeast Asia"
  resource_group_name = var.resource-groupname
  dns_prefix          = var.prefix

  default_node_pool {
    name            = "default"
    node_count      = 2
    vm_size         = "Standard_D2_v2"
    os_disk_size_gb = 30
  }

  service_principal {
    client_id     = var.appId
    client_secret = var.password
  }

  role_based_access_control {
    enabled = true
  }

  tags = {
    environment = var.env-name
  }

}
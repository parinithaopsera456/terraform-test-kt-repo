provider "azurerm" {
  region     = var.region
  subscription_id = var.subscription_id
  secret_key = var.client_id
  tenant_id  = var.tenant_id
  }
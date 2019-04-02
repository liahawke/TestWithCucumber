Feature: Customer uses site
         As a Customer,
         I want to open site,
         login with existing account,
         proceed to products page,
         add product to the cart,
         increase its quantity,
         delete product and check title
Scenario: Login And Add to cart flow
          Given The user opens site sees Home Page
          When He clicks Login link sees Login page
          When He fill login form, click login button and get Account page
          When He verifies username on Account Page
          Then Account name is 'Lia Hawke'
          When He clicks on T-shirts link, gets Listing Page
          When He clicks on product link, gets Product Page
          When He checks breadcrumbs
          Then Breadcrumb is '> Women>Tops>T-shirts>Faded Short Sleeve T-shirts'
          When He click add button and adds products to cart
          When He click proceed to checkout button and gets Checkout page
          When He increase quantity of product
          When He checks product price
          Then Price is '$35.02'
          When He deletes product from the cart
          When He checks title on empty cart page
          Then User closes browser
# to add initial data
bash add_products.sh

# get page 0 10 elements
curl "http://localhost:8080/products?page=0&size=10&sortField=name&sortOrder=asc



# HOW TO build and run the sw
docker build -t job-service .

docker run -p 8080:8080 job-service
docker build -t job-service . && docker run -p 8080:8080 job-service

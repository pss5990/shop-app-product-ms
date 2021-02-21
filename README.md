# shop-app-product-ms
A sample spring boot microservice.

#### Optional - Setting Up Skaffold
1. _brew install skaffold_. Optionally Followed by _skaffold init_ to generate a basic skaffold.yaml, the command expects a Dockerfile and K8s defination files in directory or sub-direrctory.  
2. skaffold dev. Post this skaffold will create the docker image and use the defination files to deploy the kubernetes resources.
3. Any subsequent changes (changes to the war file in our case) should not be automatically scanned and deployed.

#### Deploying Service
If you did not use skaffold we can quickly understand the setup as follows - 

1. k8s/deploy.yaml - Deployment of the mirco-service image.
2. k8s/svc.yaml - ClusterIP service to expose the deployment internally.
3. istio/shop-app-virtual-svc.yaml - This creates a virtual service that includes routes to the cluster ip service of the deployment.

#### Canary Deployment With Istio
Suppose we have a a live deployment version D1 exposed by ClusterIP service V1. Now lets say we want to rollout a new deploymeent using canary release. So say we have a deployment D2 which needs to be exposed by the service V1.
So, existing V1D1 and new is V1D2.

The way to achieve this is to have 
1. Route setup in Virtual Service declaring the weight distribution to subsets of the service.
2. We create another K8S Object called DestinationRule, defining the two subsets D1 and D2 and how they are identified(usually by labels)





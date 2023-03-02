FROM node:alpine as Builder

WORKDIR /app

COPY package.json tsconfig.json .env ./

RUN apk add --no-cache git &&  \
    npm install

COPY . .


RUN npm run build

FROM node:alpine

COPY --from=builder /app/node_modules ./node_modules
COPY --from=builder /app/package.json ./
COPY --from=builder /app/dist ./dist
COPY --from=builder /app/.env ./.env

EXPOSE 3000
CMD ["npm", "run", "start:prod"]
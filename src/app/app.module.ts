import {Module} from '@nestjs/common';
import {AppController} from './app.controller';
import {AppService} from './app.service';
import {MongooseModule} from "@nestjs/mongoose";
import {StatsModule} from "../stats/stats.module";
import {ConfigModule} from "@nestjs/config";
@Module({
    imports: [
        ConfigModule.forRoot({
            isGlobal: true
        }),
        MongooseModule.forRootAsync(
            {
                useFactory: async () => ({
                    uri: process.env.MONGO_DB
                })
            }),
        StatsModule
    ],
    controllers: [AppController],
    providers: [AppService],
})
export class AppModule {
}

import {CanActivate, ExecutionContext, Injectable} from "@nestjs/common";

@Injectable()
export class StatsGuard implements CanActivate {
    async canActivate(context: ExecutionContext): Promise<boolean> {
        const request = context.switchToHttp().getRequest();
        const key = request.key;

        return key == process.env.statsKey;
    }
}